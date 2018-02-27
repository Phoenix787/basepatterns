package com.example.basepatterns.structural.facade;

//фасад
public class Workflow {
    private Developer developer = new Developer();
    private Job job = new Job();
    private BugTracker bugTracker = new BugTracker();

    public void solveProblems() {
        job.doJob();
        bugTracker.startSprint();
        developer.doJobBeforeDeadline(bugTracker);
    }
}
