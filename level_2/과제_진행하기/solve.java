import java.util.*;
import java.io.*;

class Solution {
    private class Task {
        String name;
        int start;
        int duration;
        
        Task(String name, int start, int duration) {
            this.name = name;
            this.start = start;
            this.duration = duration;
        }
    }
    
    private void pl(Object o) {
        System.out.println(o);
    }
    
    private int convertToMinute(String time) {
        String[] splitTime = time.split(":");
        return Integer.parseInt(splitTime[0]) * 60 + Integer.parseInt(splitTime[1]);
    }
    
    public String[] solution(String[][] plans) {
        LinkedList<Task> tasks = new LinkedList<>();
        
        for (String[] plan : plans) {
            String pName = plan[0];
            int pTime = convertToMinute(plan[1]);
            int pDuration = Integer.parseInt(plan[2]);
            tasks.offer(new Task(pName, pTime, pDuration));
        }
        
        // 정렬
        tasks.sort((t1, t2) -> t1.start - t2.start);
        
        // pl(tasks);
        
        Stack<Task> waitTasks = new Stack<>();
        List<String> endTasks = new ArrayList<>();
        
        Task now = tasks.poll();
        int time = now.start;
        
        while (!tasks.isEmpty()) {
            time += now.duration;
            Task next = tasks.peek();
            
            if (time > next.start) {
                now.duration = time - next.start;
                waitTasks.add(now);
            } else {
                endTasks.add(now.name);
                if (!waitTasks.empty()) {
                    now = waitTasks.pop();
                    continue;
                }
            }
            
            now = tasks.poll();
            time = now.start;
        }
        
        endTasks.add(now.name);
        while (!waitTasks.empty()) {
            endTasks.add(waitTasks.pop().name);
        }
        
        pl(endTasks);
        
        String[] answer = endTasks.toArray(new String[0]);
        return answer;
    }
}
