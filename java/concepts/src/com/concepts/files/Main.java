package com.concepts.files;

import org.springframework.cache.interceptor.SimpleKey;

public class Main {

    public static void main(String[] args) {
        /*
         * DirectoryReader directoryReader = new DirectoryReader( new
         * File("C:\\Users\\nitesh.gupta\\Downloads")); Node directoryTree =
         * directoryReader.getDirectoryTree();
         * 
         * printEmptyDirectories(directoryTree);
         * 
         * printDirectoriesOfSize(directoryTree);
         */
        generateKey(null);

    }

    public static Object generateKey(Object... params) {
        if (params.length == 0) {
            return "";
        }
        if (params.length == 1) {
            Object param = params[0];
            if (param != null && !param.getClass().isArray()) {
                return param;
            }
        }
        return new SimpleKey(params);
    }

    private static void printDirectoriesOfSize(Node directoryTree) {
        System.out.println(directoryTree.getName());

    }

    private static void printEmptyDirectories(Node directoryTree) {
        // TODO Auto-generated method stub

    }
}
