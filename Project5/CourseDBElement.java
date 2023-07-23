
public class CourseDBElement 
{
	private String id;
	private int crn;
	private int numCredits;
	private String roomNum;
	private String instructor;
	/**
	 * Default Constructor
	 */
	public CourseDBElement() 
	{
		id = "";
		crn = 0;
		numCredits = 0;
		roomNum = "";
		instructor = "";
	}
	/**
	 * Constructor that takes parameters
	 * @param id
	 * @param crn
	 * @param numCredits
	 * @param roomNum
	 * @param instructor
	 */
	public CourseDBElement(String id, int crn, int numCredits, String roomNum, String instructor) 
	{
		this.id = id;
		this.crn = crn;
		this.numCredits = numCredits;
		this.roomNum = roomNum;
		this.instructor = instructor;
	}
	public int compareTo(CourseDBElement element)
	{
		return (this.crn - element.crn);
	}
	/**
	 * 
	 */
	public String getID()
	{
		return id;
	}
	/**
	 * 
	 */
	public String getRoomNum()
	{
		return roomNum;
	}
	/**
	 * Gets current CRN
	 * @return crn
	 */
	public int getCRN() 
	{
		return crn;
	}
	/**
	 * Sets CRN
	 * @param crn
	 */
	public void setCRN(int crn) 
	{
		this.crn = crn;
	}
	/**
	 * Gets CRN and converts it into string
	 * @return str.hashCode()
	 */
	@Override
	public int hashCode() 
	{
		String str = crn + "";
		return str.hashCode();
	}

	@Override
	public boolean equals(Object obj) 
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseDBElement o = (CourseDBElement) obj;
		if (crn != o.crn)
			return false;
		return true;
	}
	/**
	 *  returns string
	 * @return str
	 */
	@Override
	public String toString() 
	{
		String str = "\nCourse:" + id + " CRN:" + crn + " Credits:" + numCredits + " Instructor:" + instructor + " Room:" + roomNum;
		return str;
	}
	public int compareTo(Object arg0) 
	{
		// TODO Auto-generated method stub
		return 0;
	}
	

}
