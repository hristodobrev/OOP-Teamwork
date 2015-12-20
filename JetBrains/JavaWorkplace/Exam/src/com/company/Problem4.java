package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem4 {
    public static void main(String[] args) {
        // "Project":\s\["([\w]+)"\].+"Type":\s\["([\w]+)"].+"Message".+\["([\w\s]+)"\]

        // Total errors 9-0; alphabetical project; Critical Warning length 9-0
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        TreeMap<String, TreeMap<String, ArrayList<String>>> projectsData = new TreeMap<>();
        Pattern pattern = Pattern.compile
              ("\"Project\":\\s\\[\"(.+)\"\\].+\"Type\":\\s\\[\"([\\w]+)\"].+\"Message\".+\\[\"(.+)\"\\]");

        while (!line.equals("END")){

            Matcher matcher = pattern.matcher(line);

            while (matcher.find()){

                String project = matcher.group(1);
                String errorType = matcher.group(2);
                String errDiscript = matcher.group(3);

                if(!(projectsData.containsKey(project))){
                    projectsData.put(project, new TreeMap<>());
                    projectsData.get(project).put("Critical", new ArrayList<>());
                    projectsData.get(project).put("Warning", new ArrayList<>());
                }
                projectsData.get(project).get(errorType).add(errDiscript);
            }
            line = sc.nextLine();
        }

        TreeMap<Integer, TreeSet<String>> orderedProjects = new TreeMap(Collections.reverseOrder());

        for (String project : projectsData.keySet()){

            int currentErrors = 0;

            for (String error : projectsData.get(project).keySet()){
                currentErrors += projectsData.get(project).get(error).size();
            }

            if(!(orderedProjects.containsKey(currentErrors))){
                orderedProjects.put(currentErrors,new TreeSet<>());
            }

            orderedProjects.get(currentErrors).add(project);
        }

        for(Integer numErr : orderedProjects.keySet()) {

            for (String project : orderedProjects.get(numErr)) {

                System.out.println(project + ":");
                System.out.println("Total Errors: " + numErr);
                System.out.println("Critical: " + projectsData.get(project).get("Critical").size());
                System.out.println("Warnings: " + projectsData.get(project).get("Warning").size());
                System.out.println("Critical Messages:");

                ArrayList<String> orderedMap =
                        makeListAndOrderItByStringLength(projectsData.get(project).get("Critical"));

                if (orderedMap.size() > 0) {
                    for (String errText : orderedMap) {
                        System.out.println("--->" + errText);
                    }
                } else {
                    System.out.println("--->None");
                }

                System.out.println("Warning Messages:");
                orderedMap =
                        makeListAndOrderItByStringLength(projectsData.get(project).get("Warning"));
                if (orderedMap.size() > 0) {
                    for (String errText : orderedMap) {
                        System.out.println("--->" + errText);
                    }
                } else {
                    System.out.println("--->None");
                }
                System.out.println();
            }
        }
    }

    static ArrayList<String> makeListAndOrderItByStringLength(ArrayList<String> list){

        //System.out.println(list);

        TreeMap<Integer, ArrayList<String >> orderedMap = new TreeMap<>();

        for (String str : list){
            if(!(orderedMap.containsKey(str.length()))){
                orderedMap.put(str.length(), new ArrayList<>());
            }
            orderedMap.get(str.length()).add(str);
        }

        list.clear();

        for (Integer integer : orderedMap.keySet()){
            Collections.sort(orderedMap.get(integer));

            list.addAll(orderedMap.get(integer).stream().collect(Collectors.toList()));
        }

        return list;
    }
}
