/**
 * 
 */
package no.hvl.dat152.rest.ws.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 
 */
@ControllerAdvice
public class LibraryExceptionHandler {
	
	/**
	 * Specific error message
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(value = BookNotFoundException.class)
	public ResponseEntity<String> bookNotFound(BookNotFoundException ex) {		
		
		return new ResponseEntity<>("An error occured: " + ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Specific error message for update
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(value = UpdateBookFailedException.class)
	public ResponseEntity<String> updateBookFailed(UpdateBookFailedException ex) {
		
		return new ResponseEntity<>("An error occured: " + ex.getMessage(), HttpStatus.NOT_MODIFIED);
	}
	
	/**
	 * All other types of error
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<String> otherErrors(Exception ex) {
			
		return new ResponseEntity<>("An error occured: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}