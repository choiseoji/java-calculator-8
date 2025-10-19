package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CustomDelimeterHandler {

    public String extractCustomDelimeter(String command) {

        if (!hasCustomDelimeter(command))
            return null;

        int endOfDelimeter = command.indexOf("\\n");
        if (endOfDelimeter == -1)
            throw new IllegalArgumentException("커스텀 구분자는 '\\n'으로 끝나야 합니다.");

        String delimeter = command.substring(2, endOfDelimeter);
        validateDelimeter(delimeter);

        return delimeter;
    }

    public String removeDelimiterDeclaration(String command) {

        if (!hasCustomDelimeter(command))
            return command;

        int endOfDelimeter = command.indexOf("\\n");
        if (endOfDelimeter == -1)
            throw new IllegalArgumentException("커스텀 구분자는 '\\n'으로 끝나야 합니다.");

        return command.substring(endOfDelimeter + 2);
    }

    private boolean hasCustomDelimeter(String command) {

        if (command.startsWith("//"))
            return true;
        return false;
    }

    private void validateDelimeter(String delimeter) {

        if (delimeter.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("커스텀 구분자에 숫자를 넣을 수 없습니다.");
        }
    }

    public void validateContent(String content, String delimeter) {

        // 구분자 리스트
        List<String> delimiters = new ArrayList<>(Arrays.asList(",", ":"));
        if (delimeter != null)
            delimiters.add(delimeter);

        // 정규 표현식 생성
        String regex = delimiters.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));

        // 중복된 구분자 확인
        Pattern p = Pattern.compile("(" + regex + "){2,}");
        Matcher m = p.matcher(content);
        if (m.find()) {
            throw new IllegalArgumentException("구분자는 연속해서 올 수 없습니다.");
        }

        // 시작과 끝에 구분자가 오는지 확인
        for (String d : delimiters) {
            if (content.startsWith(d) || content.endsWith(d)) {
                throw new IllegalArgumentException("시작 또는 끝에 구분자가 올 수 없습니다.");
            }
        }
    }
}
