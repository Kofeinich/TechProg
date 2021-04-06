public final class Spliter {
    private String line;
    private String[] strMas;

    public Spliter(String ourLine, String[] ourMas){
        this.line = ourLine;
        this.strMas = ourMas;
    }

    public String[] mySpliter(){
        line = line.replaceAll("’","");
        strMas = line.split(";");
        return strMas;
    }
}
