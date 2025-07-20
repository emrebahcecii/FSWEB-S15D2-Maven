package org.example.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskData {

    private Set<Task> annsTasks;
    private Set<Task> bobsTasks ;
    private Set<Task> carolsTasks ;
    private Set<Task> unassignedTasks ;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks){
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String name){
        switch (name.toLowerCase()){
            case "ann":
                return this.annsTasks;
            case "bob":
                return this.bobsTasks;
            case "carol":
                return this.carolsTasks;
            case "all":
                Set<Task> allTasks = new HashSet<>();
                allTasks.addAll(annsTasks);
                allTasks.addAll(bobsTasks);
                allTasks.addAll(carolsTasks);
                allTasks.addAll(unassignedTasks);
                return allTasks;
            default: return new HashSet<>();
        }
    }

    public Set<Task> getUnassignedTasks() {
        return unassignedTasks;
    }

    public Set<Task> getUnion(Set<Task> set1, Set<Task> set2) {
        Set<Task> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);
        return unionSet;
    }
    public Set<Task> getIntersection(Set<Task>set1, Set<Task> set2){
        Set<Task> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection;
    }
    public Set<Task> getDifferences(Set<Task> set1, Set<Task>set2){
        Set<Task> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        return  difference;
    }

    public Set<Task> getDuplicatedTasks() {
        Set<Task> duplicates = new HashSet<>();
        List<Set<Task>> taskLists = List.of(annsTasks, bobsTasks, carolsTasks);

        for (int i = 0; i < taskLists.size(); i++) {
            for (int j = i + 1; j < taskLists.size(); j++) {
                Set<Task> intersection = getIntersection(taskLists.get(i), taskLists.get(j));
                duplicates.addAll(intersection);
            }
        }
        return duplicates;
    }


}
