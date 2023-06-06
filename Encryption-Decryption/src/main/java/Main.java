import encryptdecrypt.file.FileManager;
import encryptdecrypt.strategy.Context;
import encryptdecrypt.strategy.ShiftStrategy;
import encryptdecrypt.strategy.UnicodeStrategy;
import encryptdecrypt.util.ArgsParser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ArgsParser argsParser = new ArgsParser();
        argsParser.parseFromArgs(args);

        String message = "";

        Context context = new Context();
        if ("unicode".equals(argsParser.getAlg())) {
            context.setStrategy(new UnicodeStrategy());
        } else {
            context.setStrategy(new ShiftStrategy());
        }

        if (!argsParser.getIn().isEmpty() & argsParser.getData().isEmpty()) {
            message = FileManager.messageFromFile(argsParser.getIn());

        }

        if (argsParser.getOut().isEmpty()) {
            String result = check(argsParser.getMode(), argsParser.getData(), argsParser.getKey(), context);
            System.out.println(result);
        } else {
            String result = check(argsParser.getMode(), message, argsParser.getKey(), context);
            FileManager.messageToFile(result, argsParser.getOut());
        }

    }

    public static String check(String mode, String data, int key, Context context) {

        String result = null;
        if (mode.equals("enc")) {
            result = context.encode(data, key);
        }
        if (mode.equals("dec")) {
            result = context.decode(data, key);
        }

        return result;

    }

}
