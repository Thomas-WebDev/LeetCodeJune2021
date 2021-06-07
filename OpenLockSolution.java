class OpenLockSolution {
    public int openLock(String[] deadends, String target) {
        // 4D array puzzle
        // Possible solution for deadends == Hashset into queue? -- Testing
        // Use modified pathfinding algorithm
        HashSet<String> dead = new HashSet(Arrays.asList(deadends)); // track deadends provided
        HashSet<String> visited = new HashSet(); // track visisted locations
        visited.add("0000"); // starting point
        
        Queue<String> queue = new LinkedList();
        queue.offer("0000"); // add intial position
        
        int level = 0; // Track number of moves
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 0) {
                String position = queue.poll(); // check varable
                // Check is position is deadend
                if (dead.contains(position)) {
                    size--;
                    continue;
                }
                // Check is position equal to target
                if (position.equals(target)) {
                    return level;
                }
                
                // Moves
                StringBuilder sb = new StringBuilder(position);
                
                for(int i = 0; i < 4; i++) {
                    char charAtPosition = sb.charAt(i);
                    String s1 = sb.substring(0,i) + (charAtPosition == '9' ? 0 : charAtPosition - '0' + 1) + sb.substring(i+1); // incriment but move to 0 if value is 9;
                    //reverse directions
                    String s2 = sb.substring(0,i) + (charAtPosition == '0' ? 9 : charAtPosition - '0' - 1) + sb.substring(i+1); // incriment but move to 9 if value is 0;
                    if (!visited.contains(s1) && !dead.contains(s1)) {
                        queue.offer(s1);
                        visited.add(s1);
                    }
                    
                    if (!visited.contains(s2) && !dead.contains(s2)) {
                        queue.offer(s2);
                        visited.add(s2);
                    }
                }
                size--;
            }
            level++;
        }
        return -1;
    }
}
