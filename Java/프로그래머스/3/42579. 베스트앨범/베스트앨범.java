import java.util.*;

class Solution {
    class Music {
        int index;
        int played;
        String genre;

        Music(int index, int played, String genre) {
            this.index = index;
            this.played = played;
            this.genre = genre;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genrePlayCount = new HashMap<>();
        Map<String, List<Music>> genreMusicMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + play);
            genreMusicMap.putIfAbsent(genre, new ArrayList<>());
            genreMusicMap.get(genre).add(new Music(i, play, genre));
        }

        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((g1, g2) -> genrePlayCount.get(g2) - genrePlayCount.get(g1));

        List<Integer> result = new ArrayList<>();

        for (String genre : sortedGenres) {
            List<Music> musicList = genreMusicMap.get(genre);
            musicList.sort((m1, m2) -> m2.played == m1.played ? m1.index - m2.index : m2.played - m1.played);

            for (int i = 0; i < Math.min(2, musicList.size()); i++) {
                result.add(musicList.get(i).index);
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}