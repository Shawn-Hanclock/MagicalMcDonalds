import java.util.ArrayList;

public class Unicorn extends MagicalAnimal
{
    private int hornSharp;
    private int rainbowRange;
    //instance variables


    public Unicorn(String name, int speed, String type) {
        super(name, speed, type);
        this.type = "Unicorn";
    }

    public Unicorn(String name)
    {
        super(name);
        this.weight = Math.round((Math.random() * 190) + 20);
        this.type = "Unicorn";
        this.rainbowRange =  (int)(Math.random() * 80) + 50;
        this.hornSharp = (int)(Math.random() * 5) + 1;
    }//end of constructor full

    @Override
    public String toString() {
        return "(Unicorn)" + super.toString() +
                "\n  horn sharpnss: " + this.hornSharp +
                "\n  rainbw range: " + this.rainbowRange;
    }//end of tostring

    @Override
    public void setSpeed()
    {
        super.setSpeed();
        this.speed = this.speed + (int)(rainbowRange /(Math.sqrt(weight)) * ((hornSharp % 2 == 0) ? 100: 1));
    }

    @Override
    public void findPlace(ArrayList<MagicalAnimal> racers, MagicalAnimal e)
    {
        e.setSpeed();
        Unicorn creatureU = new Unicorn(e.getName(), e.getSpeed(), e.getType());
        if(racers.isEmpty()) {
            super.findPlace(racers, e);
        }
        else
        {
            int setSpot = 0;
            for(int i = racers.size(); i >= 1; i--)
            {
                if(i == 0)
                {
                    setSpot = 0;
                }
                else if(racers.get(i - 1).getSpeed() < creatureU.getSpeed())
                {
                    setSpot = i -1;
                }
                else
                {
                    setSpot = racers.size() - 1;
                }
            }
            racers.add(setSpot, creatureU);
        }
    }//end of findplacce
}
