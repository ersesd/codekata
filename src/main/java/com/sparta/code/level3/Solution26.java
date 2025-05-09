package com.sparta.code.level3;

import java.util.*;

class Solution26 {

    static class Song implements Comparable<Song> {
        int id;
        int plays;

        Song(int id, int plays) {
            this.id = id;
            this.plays = plays;
        }

        @Override
        public int compareTo(Song other) {
            if (this.plays != other.plays) {
                return Integer.compare(other.plays, this.plays);
            } else {
                return Integer.compare(this.id, other.id);
            }
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreTotalPlays = new HashMap<>();
        Map<String, List<Song>> songsByGenre = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int playCount = plays[i];

            genreTotalPlays.put(genre, genreTotalPlays.getOrDefault(genre, 0) + playCount);
            songsByGenre.computeIfAbsent(genre, k -> new ArrayList<>()).add(new Song(i, playCount));
        }

        List<String> sortedGenres = new ArrayList<>(genreTotalPlays.keySet());
        Collections.sort(sortedGenres, (g1, g2) -> genreTotalPlays.get(g2).compareTo(genreTotalPlays.get(g1)));

        List<Integer> bestAlbumIds = new ArrayList<>();

        for (String genre : sortedGenres) {
            List<Song> currentGenreSongs = songsByGenre.get(genre);
            Collections.sort(currentGenreSongs);

            bestAlbumIds.add(currentGenreSongs.get(0).id);
            if (currentGenreSongs.size() > 1) {
                bestAlbumIds.add(currentGenreSongs.get(1).id);
            }
        }

        return bestAlbumIds.stream().mapToInt(Integer::intValue).toArray();
    }
}