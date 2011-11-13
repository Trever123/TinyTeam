package tinyteam;

import java.io.*;
import java.util.*;

class FileList {

    public static ArrayList<String> dirList(String fname) {
        ArrayList<String> al = new ArrayList<String>();
        String[] parent = new File(fname).list();
        if (parent == null) {
            System.out.println("Specified directory does not exist or is not a directory.");
        } else {
            for (int i = 0; i < parent.length; i++) {
                String[] child = new File(fname + File.separator + parent[i]).list();
                if (!(child == null)) {
                    for (int k = 0; k < child.length; k++) {
                        if (child[k].equals("DONE")) {
                            break;
                        }
                        if (child[k].equals("GO")) {
                            al.add(fname + File.separator + parent[i]);
                        }
                    }
                }
            }
        }
        return al;
    }
}
