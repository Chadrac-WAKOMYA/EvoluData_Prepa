package last_prepa;

public class BoatMovements {
    public static boolean canTravelTo(boolean[][] gameMatrix, int fromRow, int fromColumn, int toRow, int toColumn) {
        // Check if destination is out of bounds
        if (toRow < 0 || toColumn < 0 || toRow >= gameMatrix.length || toColumn >= gameMatrix[0].length) {
            return false; // Out of bounds
        }

        // Check if the destination is valid
        if (!gameMatrix[toRow][toColumn]) {
            return false; // Not a valid destination (land)
        }

        // Use a helper method to check path availability
        boolean[][] visited = new boolean[gameMatrix.length][gameMatrix[0].length];
        return canReach(gameMatrix, fromRow, fromColumn, toRow, toColumn, visited);
    }

    private static boolean canReach(boolean[][] gameMatrix, int x, int y, int destX, int destY, boolean[][] visited) {
        // Check boundaries and conditions
        if (x < 0 || y < 0 || x >= gameMatrix.length || y >= gameMatrix[0].length || visited[x][y] || !gameMatrix[x][y]) {
            return false;
        }

        // Mark this cell as visited
        visited[x][y] = true;

        // Check if reached destination
        if (x == destX && y == destY) {
            return true;
        }

        // Explore the four possible directions (up, down, left, right)
        return canReach(gameMatrix, x + 1, y, destX, destY, visited) || // down
               canReach(gameMatrix, x - 1, y, destX, destY, visited) || // up
               canReach(gameMatrix, x, y + 1, destX, destY, visited) || // right
               canReach(gameMatrix, x, y - 1, destX, destY, visited);   // left
    }

    public static void main(String[] args) {
        boolean[][] gameMatrix = {
            {false, true,  true,  false, false, false},
            {true,  true,  true,  false, false, false},
            {true,  true,  true,  true,  true,  true},
            {false, true,  true,  false, true,  true},
            {false, true,  true,  true,  false, true},
            {false, false, false, false, false, false},
        };

        System.out.println(canTravelTo(gameMatrix, 3, 2, 2, 2)); // true, Valid move
        System.out.println(canTravelTo(gameMatrix, 3, 2, 3, 4)); // false, Can't travel through land
        System.out.println(canTravelTo(gameMatrix, 3, 2, 6, 2)); // false, Out of bounds
    }
}