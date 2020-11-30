package com.zx.zxtest.abc;

import java.io.File;

public class UpdateName {

    public static void main(String[] args) {
        updateName("D:\\project\\spb\\task-order-server\\src\\main\\java\\com\\zxhc\\abcc");
    }

    public static int updateName(String path){
        int t = 0;
        File file = new File(path);
        if (file.isDirectory()){
            File[] list = file.listFiles();
            for (File files:list){
                System.out.println(files.getName());
                updateName(files.getPath());
            }
        }else{
            String parentPath = file.getParent();
            String lastName ="Sms"+file.getName();
            System.out.println("修改前文件名称是："+file.getName());
            System.out.println("修改后文件名称是："+lastName);
            File fl = new File(parentPath+File.separator+lastName);
            if (file.renameTo(fl)) {
                System.out.println("修改成功!");
            }else {
                System.out.println("修改失败");
            }

        }
        return t;
    }
}
