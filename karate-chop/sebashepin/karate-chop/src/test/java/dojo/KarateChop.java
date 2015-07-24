package dojo;

public class KarateChop {

    public int complexity;

    private int[] counter;

    public KarateChop() {
    }

    Integer binarySearch(Integer[] integers, Integer query) {
        complexity = 0;
        counter = new int[integers.length];
        Integer position = -1;
        if (integers.length == 0) {
            position = -1;
        } else {
            int startingPosition = 0;
            int endingPosition = integers.length - 1;
            for (int i = startingPosition; i <= endingPosition && position == -1; i++) {
                int middlePosition = getMiddlePosition(startingPosition,endingPosition);
                int middleValue = getInteger(middlePosition, integers);
                if (middleValue == query) {
                    position = middlePosition;
                } else if (startingPosition == endingPosition) {
                    break;
                }
                boolean valueSmallerThanMiddle = query <= middleValue;

                startingPosition = valueSmallerThanMiddle ? startingPosition : middlePosition + 1;
                endingPosition = valueSmallerThanMiddle ? middlePosition : endingPosition;
            }
        }
        return position;
    }

    private int getMiddlePosition(int start, int end) {
        return ((end-start) / 2)+start;
    }

    private int getInteger(int position, Integer[] array) {
        counter[position]++;
        complexity++;
        return array[position];
    }
}