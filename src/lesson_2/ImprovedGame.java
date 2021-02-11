package lesson_2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ImprovedGame {
    private static char[][] map;
    private static int mapSize;

    private static char human_dot = 'X';
    private static char ai_dot = 'O';
    private static char empty_dot = '_';

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        inputMapSize();
        createMap();

        while (true) {
            humanTurn();
            printMap();
            if (checkWin(human_dot)) {
                System.out.println("Human WIN!");
                if (oneMoreRound()) {
                    createMap();
                    continue;
                }
                break;
            }
            if (isFullMap()) {
                System.out.println("DRAW!");
                if (oneMoreRound()) {
                    createMap();
                    continue;
                }
                break;
            }

            aiTurn();
            printMap();
            if (checkWin(ai_dot)) {
                System.out.println("AI WIN!");
                if (oneMoreRound()) {
                    createMap();
                    continue;
                }
                break;
            }
            if (isFullMap()) {
                System.out.println("DRAW!");
                if (oneMoreRound()) {
                    createMap();
                    continue;
                }
                break;
            }
        }
    }

    private static void inputMapSize() {
        do {
            System.out.println("Enter map size: ");
            mapSize = scanner.nextInt();
        } while (!isValidMapSize(mapSize));
        System.out.println("You choose map size - " + mapSize + "x" + mapSize);
    }

    private static boolean isValidMapSize(int mapSize) {
        return mapSize > 2 && mapSize < 10;
    }

    private static void createMap() {
        map = new char[mapSize][mapSize];

        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                map[y][x] = empty_dot;
            }
        }
    }

    private static void printMap() {
        System.out.println("~~~~~~~~~~~~~~~~~");
        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                System.out.print(map[y][x] + "|");
            }
            System.out.println();
        }
        System.out.println("~~~~~~~~~~~~~~~~~");
    }

    private static void humanTurn() {
        int y;
        int x;

        do {
            System.out.println("Enter your coordinates: ");
            y = scanner.nextInt() - 1;
            x = scanner.nextInt() - 1;
        } while (!isValidCell(y, x) || !isEmptyCell(y, x));

        map[y][x] = human_dot;
    }

    private static void aiTurn() {
        int y;
        int x;

        do {
            y = random.nextInt(mapSize);
            x = random.nextInt(mapSize);
        } while (!isEmptyCell(y, x));

        map[y][x] = ai_dot;
    }

    private static boolean isEmptyCell(int y, int x) {
        return map[y][x] == empty_dot;
    }
    private static boolean isValidCell(int y, int x) {
        return x >= 0 && x < mapSize && y >= 0 && y < mapSize;
    }
    private static boolean checkCurrentPlayer(char player, char[] line) {
        for (int i = 0; i < mapSize; i++) {
            if (line[i] != player) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkWin(char currentPlayer){

        boolean isRowOrColWin = false;
        boolean isMainDiagonalWin = true;
        boolean isAntiDiagonalWin = true;

        for (int x = 0; x < mapSize; x++) {
            boolean isRowWin = true;
            boolean isColWin = true;

            for (int y = 0; y < mapSize; y++) {
                isRowWin = isRowWin && map[x][y] == currentPlayer;
                isColWin = isColWin && map[y][x] == currentPlayer;
            }
            isRowOrColWin = isRowOrColWin || isRowWin || isColWin;

            isMainDiagonalWin = isMainDiagonalWin && map[x][x] == currentPlayer;
            isAntiDiagonalWin = isAntiDiagonalWin && map[x][mapSize - x - 1] == currentPlayer;
        }

        return isRowOrColWin || isMainDiagonalWin || isAntiDiagonalWin;
    }

    private static boolean isFullMap() {
        for (int y = 0; y < mapSize; y++) {
            for (int x = 0; x < mapSize; x++) {
                if (map[y][x] == empty_dot) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean oneMoreRound() {
        int answer;
        do {
            System.out.println("Do you want to play one more round (1 - yes / 0 - no): ");
            answer = scanner.nextInt();
        } while (answer < 0 || answer > 1);

        return answer == 1;
    }
}
