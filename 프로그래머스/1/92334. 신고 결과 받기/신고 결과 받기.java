import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportMap = new HashMap<>();
        Map<String, Integer> reportCount = new HashMap<>();

        for (String r : report) {
            String[] split = r.split(" ");
            String reporter = split[0];
            String reported = split[1];

            reportMap.putIfAbsent(reporter, new HashSet<>());
            if (reportMap.get(reporter).add(reported)) {
                reportCount.put(reported, reportCount.getOrDefault(reported, 0) + 1);
            }
        }

        Set<String> bannedUsers = new HashSet<>();
        for (String user : reportCount.keySet()) {
            if (reportCount.get(user) >= k) {
                bannedUsers.add(user);
            }
        }

        int[] answer = new int[id_list.length];
        Map<String, Integer> mailCount = new HashMap<>();

        for (String id : id_list) {
            mailCount.put(id, 0);
        }

        for (String reporter : reportMap.keySet()) {
            for (String reported : reportMap.get(reporter)) {
                if (bannedUsers.contains(reported)) {
                    mailCount.put(reporter, mailCount.get(reporter) + 1);
                }
            }
        }

        for (int i = 0; i < id_list.length; i++) {
            answer[i] = mailCount.get(id_list[i]);
        }

        return answer;
    }
}
