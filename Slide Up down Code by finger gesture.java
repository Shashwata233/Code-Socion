public class MainActivity extends AppCompatActivity {
    private float startY;
    private float endY;
    private static final int MIN_SWIPE_DISTANCE = 50;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                // record the starting Y position
                startY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                // record the ending Y position
                endY = event.getY();

                // calculate the distance between start and end positions
                float distance = endY - startY;

                // check if the distance is greater than the minimum swipe distance
                if (Math.abs(distance) > MIN_SWIPE_DISTANCE) {
                    // check the direction of the swipe
                    if (distance < 0) {
                        // finger slide up detected
                        Toast.makeText(this, "Finger slide up detected!", Toast.LENGTH_SHORT).show();
                    } else {
                        // finger slide down detected
                        Toast.makeText(this, "Finger slide down detected!", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }

        return super.onTouchEvent(event);
    }
}
