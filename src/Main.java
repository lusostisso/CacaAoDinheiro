
public class Main {
    public static void main(String[] args) {

        ArquivoLeitura arquivo = new ArquivoLeitura();
        arquivo.open("./CasosTeste/casoG50.txt");

        int [] tam = arquivo.tam();
        Mapa map = new Mapa(tam);
        int valorRoubo = 0;

        //feed map
        feedMap(tam[0], arquivo, map);

        //find initial point, [the return of the function, 0]
        int [] pos = findInicialPoint(map);

        //navigate

        char obstaculo = navigateRight(map, pos);

        if (Character.isDigit(obstaculo)){
            valorRoubo += obstaculo - '0';
        }

        System.out.println(valorRoubo);



    }

    public static void feedMap(int qntLinha, ArquivoLeitura arquivo, Mapa map) {
        for (int j = 0; j < qntLinha; j++) {
            char[] line = arquivo.lerLinha().toCharArray();
            for (int i = 0; i < (line).length; i++) {
                map.setElementMap(new int[]{j, i}, line[i]);
            }
        }
    }

    public static int [] findInicialPoint(Mapa map) {
        for (int i = 0; i<map.getLinesLength(); i++) {
            if(map.getElementMap(i,0)=='-'){
                return new int [] {i, 0};
            }
        }
        return null;
    }

    public static char navigateRight (Mapa map, int [] pos) {
        int linha = pos [0];
        int coluna = pos [1];
        while (map.getElementMap(linha, coluna)=='-') {
            coluna++;
        }
        return map.getElementMap(linha,coluna);
    }

    public static char navigateLeft (Mapa map, int [] pos) {
        int linha = pos [0];
        int coluna = pos [1];
        while (map.getElementMap(linha, coluna)=='-') {
            coluna--;
        }
        return map.getElementMap(linha,coluna);
    }

    public static char navigateUp (Mapa map, int [] pos) {
        int linha = pos [0];
        int coluna = pos [1];
        while (map.getElementMap(linha, coluna)=='|') {
            linha--;
        }
        return map.getElementMap(linha,coluna);
    }

    public static char navigateDown (Mapa map, int [] pos) {
        int linha = pos [0];
        int coluna = pos [1];
        while (map.getElementMap(linha, coluna)=='|') {
            linha++;
        }
        return map.getElementMap(linha,coluna);
    }

}