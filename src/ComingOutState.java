
public class ComingOutState extends State {
// ------------------------------------------------------------------------
// First roll of dice:
//    2,3, or 12 Loss ("craps")  
//    7 or 11 Win ("natural")
//    any other (4,5,6,8,9,10) establishes "points"
// ------------------------------------------------------------------------
    private int roll;

    public ComingOutState(Dice dice) {
        super(dice);
    }
    
     public ComingOutState(State source) {
        super(source);
        System.out.println("** Invalid State Transition Exception **");
        System.exit(0);
    }

    public void transitionState() {  
        roll = getContext().getCurrentRoll();
        if(roll == 2 || roll == 3 || roll == 12){
            //transition to lose
            getContext().setState(new Loss(getContext()));
        }
        else if(roll == 7 || roll == 11){
            //transition to win
            getContext().setState(new Win(getContext()));
        }
        else{
            //transition to point
            getContext().setState(new PointState(getContext().getState()));
        }
    }
    //  transitions to either a Win, Loss or Points state 
    
}
