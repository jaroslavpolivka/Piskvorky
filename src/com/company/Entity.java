package com.company;

class Plocha {

    String[][] plocha;

    public Plocha(int i,int j) {
        plocha = new String[i][j];
    }

    public void ukazPlochu(){

        for(String[] radek : plocha) {
            for(String bunka : radek){
                System.out.print(bunka + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean jePoziceVolna(int radek, int sloupec){
        return plocha[radek][sloupec]==null;
    }

    public void umistiZnak(int radek, int sloupec, String znak){
        plocha[radek][sloupec]=znak;
    }

    public Hrac zjistiViteze(Hrac hrac1, Hrac hrac2){

        Hrac[] hraci = {hrac1, hrac2};
        Hrac winner = null;

        for(int i = 0; i < hraci.length; i++) {

            winner = hraci[i];
            //vodorovne
            for (int radek = 0; radek < plocha.length; radek++) {

                for (int sloupec = 0; sloupec < plocha[radek].length; sloupec++) {
                    if(plocha[radek][sloupec] != null){
                        if(!plocha[radek][sloupec].equals(hraci[i].getSymbol())) {
                            winner = null;
                            break;
                        }
                    }
                    if(plocha[radek][sloupec] == null){
                       winner=null;
                       break;
                    }
                } //konec vnitrni
                if(winner!=null) return winner;
                winner = hraci[i];
            } //konec vnejsi

            //diagonalne
            /*if( (plocha[0][0] != null) && (plocha[1][1] != null) && (plocha[2][2] != null)) {
                if (plocha[0][0].equals(hraci[i].getSymbol()) && plocha[1][1].equals(hraci[i].getSymbol())
                        && plocha[2][2].equals(hraci[i].getSymbol())) winner = hraci[i];
            }
            if((plocha[0][2] != null) && (plocha[1][1] != null) && (plocha[2][0] != null)){
                if (plocha[0][2].equals(hraci[i].getSymbol()) && plocha[1][1].equals(hraci[i].getSymbol())
                        && plocha[2][0].equals(hraci[i].getSymbol())) winner = hraci[i];
            }*/
        }
        return null;
    }

    public boolean jePlnaPlocha(){

        boolean zaplneno = true;

        for(String[] radek : plocha) {
            for(String bunka : radek){
                if(bunka==null) zaplneno=false;
            }
        }
    return zaplneno;
    }
}

class Hrac{
    String name, symbol;
    int radek, sloupec;
    public Hrac(String symbol) {this.symbol = symbol;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getSymbol() {return symbol;}
    public int getRadek() {return radek;}
    public void setRadek(int radek) {this.radek = radek;}
    public int getSloupec() {return sloupec;}
    public void setSloupec(int sloupec) {this.sloupec = sloupec;}
}


