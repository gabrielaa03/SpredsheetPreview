package com.gabriela.googlespreadsheetpreview.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TableUtils {

    private static final Pattern VALID_PATTERN = Pattern.compile("[0-9]+|[A-Z]+");

    public static List<String> parse(String toParse) {
        List<String> chunks = new LinkedList<>();
        Matcher matcher = VALID_PATTERN.matcher(toParse);
        while (matcher.find()) {
            chunks.add(matcher.group());
        }
        return chunks;
    }

    public static TextView getTextView(String text, int drawableResource, Context context) {
        TextView textView = new TextView(context);
        textView.setText(text);
        textView.setBackgroundResource(drawableResource);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(20);
        textView.setWidth(200);
        textView.setHeight(50);
        return textView;
    }

    public static int getPositionInArray(Character character, char[] alphabet) {
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == character) {
                return i;
            }
        }
        return 0;
    }

    public static List<Character> getAlphabetList(char[] alphabet) {
        List<Character> alphabetList = new ArrayList<>();
        for (char character : alphabet) {
            alphabetList.add(character);
        }
        return alphabetList;
    }

}
