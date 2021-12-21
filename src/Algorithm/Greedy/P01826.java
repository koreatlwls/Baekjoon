package Algorithm.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P01826 {
    static int n, l, p;
    static int ans = 0;
    static PriorityQueue<Station> stations;

    static class Station {
        int location, Petrol;

        Station(int location, int Petrol) {
            this.location = location;
            this.Petrol = Petrol;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        stations = new PriorityQueue<>(new Comparator<Station>() {
            @Override
            public int compare(Station o1, Station o2) {
                return Integer.compare(o1.location, o2.location);
            }
        });

        int sum = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            stations.add(new Station(a, b));

            sum += b;
        }

        st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());

        if (sum + p < l) {
            System.out.println(-1);
            return;
        }

        int currentLocation = 0;
        int reachableLocation = p;
        int currentPetrol = p;

        PriorityQueue<Station> reachableStations = new PriorityQueue<>(new Comparator<Station>() {
            @Override
            public int compare(Station o1, Station o2) {
                return Integer.compare(o1.Petrol, o2.Petrol) * -1;
            }
        });

        Station nextStation;
        while (reachableLocation < l) {

            while (!stations.isEmpty() && stations.peek().location <= reachableLocation) {
                reachableStations.add(stations.remove());
            }

            if (reachableStations.isEmpty()) {
                ans = -1;
                break;
            }

            nextStation = reachableStations.remove();
            ans++;

            if (nextStation.location < currentLocation) {
                reachableLocation += nextStation.Petrol;
                currentPetrol += nextStation.Petrol;
            } else {
                int usedPetrol = nextStation.location - currentLocation;
                currentLocation = nextStation.location;
                currentPetrol = currentPetrol + nextStation.Petrol - usedPetrol;
                reachableLocation = currentLocation + currentPetrol;
            }
        }

        System.out.println(ans);
    }
}

