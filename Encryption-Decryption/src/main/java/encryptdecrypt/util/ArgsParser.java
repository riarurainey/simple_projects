package encryptdecrypt.util;

public class ArgsParser {
    private String mode = "enc";
    private int key = 0;
    private String data = "";
    private String in = "";
    private String out = "";
    private String alg = "shift";


    public String getMode() {
        return mode;
    }

    public int getKey() {
        return key;
    }

    public String getData() {
        return data;
    }

    public String getIn() {
        return in;
    }

    public String getOut() {
        return out;
    }

    public String getAlg() {
        return alg;
    }


    public void parseFromArgs(String[] strings) {
        for (int i = 0; i < strings.length - 1; i++) {
            switch (strings[i]) {
                case "-mode":
                    this.mode = strings[++i];
                    break;
                case "-key":
                    this.key = Integer.parseInt(strings[++i]);
                    break;
                case "-data":
                    this.data = strings[++i];
                    break;
                case "-in":
                    this.in = strings[++i];
                    break;
                case "-out":
                    this.out = strings[++i];
                    break;
                case "-alg":
                    this.alg = strings[++i];
                    break;

            }
        }

    }
}