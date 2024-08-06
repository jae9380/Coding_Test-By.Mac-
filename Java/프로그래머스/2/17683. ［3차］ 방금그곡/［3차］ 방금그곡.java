class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int maxTime=-1;
        m=replace(m);
        for(String music:musicinfos) {
            String[] info=music.split(","), start=info[0].split(":"), end=info[1].split(":");
            int runTime=60*(Integer.parseInt(end[0])-Integer.parseInt(start[0]))+Integer.parseInt(end[1])-Integer.parseInt(start[1]);

            String part = "";
            info[3]=replace(info[3]);

            if(runTime<=info[3].length()) {
                part=info[3].substring(0,runTime);
            }
            else {
                for(int i=0;i<runTime/info[3].length(); i++) {
                    part+=info[3];
                }
                part+= info[3].substring(0,runTime%info[3].length());
            }
            if(part.contains(m) &&runTime > maxTime) {
                maxTime = runTime;
                answer = info[2];
            }
        }
        
        return answer.isEmpty()?"(None)":answer;
    }
    static String replace(String m) {
        return m.replaceAll("A#","a")
                .replaceAll("B#","b")
                .replaceAll("C#","c")
                .replaceAll("D#","d")
                .replaceAll("E#","e")
                .replaceAll("F#","f")
                .replaceAll("G#","g");
    }
}