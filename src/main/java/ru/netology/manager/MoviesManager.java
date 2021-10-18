package ru.netology.manager;

import ru.netology.domain.Movie;

private class MoviesManager {
    private Movie[] movies = new Movie[0];
    private int limit;

    MoviesManager() {
        this.limit = 10;
    }

    MoviesManager(int limit) {
        this.limit = limit;
    }

    public void add(Movie movie) {
        // создаём новый массив размером на единицу больше
        int length = this.movies.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(this.movies, 0, tmp, 0, this.movies.length);
        // кладём последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        this.movies = tmp;
    }

    public Movie[] getLatest() {
        int resultLength;
        if (this.movies.length < this.limit) {
            resultLength = this.movies.length;
        }
        else {
            resultLength = this.limit;
        }
        Movie[] result = new Movie[resultLength];
        // перебираем массив в прямом порядке
        // но кладём в результаты в обратном
        for (int i = 0; i < resultLength; i++) {
            int index = this.movies.length - i - 1;
            result[i] = this.movies[index];
        }
        return result;
    }
}
