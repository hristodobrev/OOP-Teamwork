package com.company.JavaBasics_February08;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Parapanov on 09/11/2015.
 *
 */
public class Problem_04_UserLogs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Integer>> usersData = new TreeMap<>();

        String line = sc.nextLine();
        Pattern pattern = Pattern.compile("([\\w]*\\w+[\\:\\.]\\w+[\\:\\.]\\w+[\\:\\.]\\w+[\\:\\d\\w]*).+\\=(\\w+)");

        while (!(line.equals("end"))){
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                String user = matcher.group(2);
                String ip = matcher.group(1);

                if(!(usersData.containsKey(user))){
                    usersData.put(user, new LinkedHashMap<>());
                }
                if(!(usersData.get(user).containsKey(ip))){
                    usersData.get(user).put(ip, 0);
                }
                int curUserNum =  usersData.get(user).get(ip);

                usersData.get(user).put(ip,curUserNum + 1);
            }

            line = sc.nextLine();
        }

        for(String name : usersData.keySet()){
            System.out.println(name + ": ");

            String ipLine = "";
            for(String ip : usersData.get(name).keySet()){

                ipLine += ip + " => " + usersData.get(name).get(ip) + ", ";
            }
            System.out.println(ipLine.substring(0, ipLine.length() - 2) + ".");
        }
    }
}
