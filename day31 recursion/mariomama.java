    static class Node implements Comparable<Node> 
    {
        int place, time;
        boolean usedMagic;

        public Node(int place, int time, boolean usedMagic) 
        {
            this.place = place;
            this.time = time;
            this.usedMagic = usedMagic;
        }

        @Override
        public int compareTo(Node other) 
        {
            return Integer.compare(this.time, other.time);
        }
    }

    public static int findMinTime(int n, int m, List<List<Integer>> Routes) 
    {
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) 
        {
            graph[i] = new ArrayList<>();
        }

        for (List<Integer> route : Routes) 
        {
            int a = route.get(0), b = route.get(1), c = route.get(2);
            graph[a].add(new int[]{b, c});
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[][] dist = new int[n + 1][2];
        
        for (int i = 1; i <= n; i++) 
        {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        dist[1][0] = 0;
        pq.offer(new Node(1, 0, false));

        while (!pq.isEmpty()) 
        {
            Node current = pq.poll();
            int place = current.place;
            int time = current.time;
            boolean usedMagic = current.usedMagic;

            if (place == n) 
            {
                return time;
            }

            for (int[] neighbor : graph[place]) 
            {
                int nextPlace = neighbor[0];
                int travelTime = neighbor[1];

                if (!usedMagic && time + travelTime < dist[nextPlace][0]) 
                {
                    dist[nextPlace][0] = time + travelTime;
                    pq.offer(new Node(nextPlace, dist[nextPlace][0], false));
                }

                int halfTime = travelTime / 2;
                if (!usedMagic && time + halfTime < dist[nextPlace][1]) 
                {
                    dist[nextPlace][1] = time + halfTime;
                    pq.offer(new Node(nextPlace, dist[nextPlace][1], true));
                }
                
                if (usedMagic && time + travelTime < dist[nextPlace][1]) 
                {
                    dist[nextPlace][1] = time + travelTime;
                    pq.offer(new Node(nextPlace, dist[nextPlace][1], true));
                }
            }
        }

        return Math.min(dist[n][0], dist[n][1]);
    }
