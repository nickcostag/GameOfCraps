
public class PointState extends State {
// ------------------------------------------------------------------------
// Second roll of dice:
//    7 Loss ("seven out")
//    match of previous roll Win ("hits the points")
//    any other, roll again
// ------------------------------------------------------------------------    
    private int points_to_match;

    public PointState(State source) {
        super(source);
        points_to_match = source.getContext().getCurrentRoll();
    }
    
    public PointState(Dice dice) {
        super(dice);
        System.out.println("** Invalid State Transition Exception **");
        System.exit(0);
    }

    public void transitionState() {  
        if(getContext().getCurrentRoll() == points_to_match){
            getContext().setState(new Win(getContext()));
        }
        else if(getContext().getCurrentRoll() == 7){
            getContext().setState(new Loss(getContext()));
        }
    }
    //  transitions to either a Win or Loss state    
}


