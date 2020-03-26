# JAVADOC README
## Introduction
This document will assist in working with Javadoc by providing annotation reference with examples. Also, will provide guidelines in developing specific comments to be imported into JAVADOC.  This document references the following links:

[https://gist.github.com/ashishrana160796/4ac492caa9b306eac0adb3716e8b76d3](https://gist.github.com/ashishrana160796/4ac492caa9b306eac0adb3716e8b76d3)
[https://www.oracle.com/technetwork/java/javase/documentation/index-137868.html](https://www.oracle.com/technetwork/java/javase/documentation/index-137868.html)

##  Inserting a Comment 
   /**    Begins the comment 
    *    Starts each new line of a comment
*/      Ends the comment
Example:  
			/ ** 
			* Returns an Image Object that can be painted on the screen
			*  The url argument must specify an absolute (@link url). The name
			* argument is a specifier that is relative to the url argument.
			* <p>
			* This method always returns immediately, whether or not the
			* image exists. When this applet attempts to draw the image on
			* the screen, the data will be loaded. The graphics primitives
			* that draw the image will incrementally paint on the screen.
			* [@param] url  an absolute URL giving the base location of the image
			* [@param] name the location of the image, relative to the url argument
			* [@return]the image at the specified URL
			*  [@see] Image
			* /
			public Image getImage(Url url, String name) {
			}
### Meta Annotations
	@author    Ex: @author Jane Doe
	@version   Ex: @version v1.0
	@since     Ex: @since 2020-03-23

### Method Annotations
	@param parameter description  Ex: @param img the image to be passed
	@return parameter description  Ex: @return img the image to be returned
	@throws/exception parameter description  Ex: @throw IOException if I/O exception occurred
	@deprecated deprecated-text""  Ex: @deprecated since version v2.0
### Linking
	@see reference  Ex: @see package.ClassA/url/string
	{@link package.class#member label} Ex: {@link URL}/{@link Image-Observer} This link will do something
	@serial/serialField/serialData Ex: @serialField Field1

## Notes

Tags should be in the following order within a comment: 
@author (classes and interfaces)  
@version (classes and interfaces)  
@param (methods and constructors)  
@return (methods)  
@exception (@throws from Javadoc 1.2)  
@see (If multiple @see, then order according to distance from current file)  
@since (Follow format throughout document)  
@serial (or @serialField or @serialData)  
@deprecated (see How and When To Deprecate APIs)

### Basic Command Examples

 1.  javadoc AddAcc.java : Simply creates Javadoc file in the same directory.
 2.   javadoc -d doc BankAcc.java : creates Javadoc files for the specified file in same directory in specified folder  **doc**.
3.   javadoc -d doc bankpackage/*.java : Javadoc files for complete package created in  **doc**  folder in current directory.
4.   javadoc -tag newTag. : a : ”New Tag: “ -d doc BankAcc.java : For adding new custom tag in documentation for either specified file or package.

