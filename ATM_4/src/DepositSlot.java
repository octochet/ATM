//deposit slot object.
//Here we assume that deposit slot is working fine always and hence return true always.
//IRL there may be some problems and glitches in the sensor code in that case it will return false.
//IRL the sensor code will be written here.
public class DepositSlot {
	
	public boolean isEnvelopeReceived()
	{
		return true;	
	}
	
}