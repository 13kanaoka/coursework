
package LAB02;
/*
* Request.java
*
*/
/** A class to represent a request. */
public class Request {
// Data Fields
/** The ID number for this request. */
private final int requestId;
/** The time needed to process this request. */
private final int processingTime;
/** The time this request arrives. */
private final int arrivalTime;
/** The sequence number. */
private static int idNum = 0;
/** Create a new passenger.
* @param arrivalTime The time this request arrives
* @param procTime The processing time
*/
public Request(int arrivalTime, int procTime) {
this.arrivalTime = arrivalTime;
this.processingTime = procTime;
requestId = idNum++;
}
/** Get the arrival time.
@return The arrival time */
public int getArrivalTime() {
return arrivalTime;
}
/** Get the processing time.
@return The processing time */
public int getProcessingTime() {
return processingTime;
}
/** Get the request ID.
@return The request ID */
public int getId() {
return requestId;
}
}