public class Mapa {
    private char [][] map;

    public Mapa (int [] tam) {
        this.map = new char[tam[0]][tam[1]];
    }

    public int getLinesLength() {
        return map.length;
    }

    public void setElementMap(int [] posi, char element) {
        this.map[posi[0]][posi[1]]= element;
    }

    public char getElementMap(int linha, int coluna) {
        return map[linha][coluna];
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mapa{\n");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append("}");
        return sb.toString();
    }

}
