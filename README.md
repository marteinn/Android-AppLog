Android-AppLog
==============
AppLog is a custom Android logger that accept more loggable types and can reuse the tag argument.

## How it works
AppLog is the main class that works as a wrapper around android.util.Log and allows more loggable types and possibility to mute logging. I have also included a class called **TagLog** (that you can instantiate from AppLog) that stores the tag and interacts with AppLog for debugging, so you can simplify your log calls even more.

## Implementation

### AppLog:

Just import and call AppLog as you would with the built in Log class.

	import se.marteinn.utils.AppLog;
	
	AppLog.i(TAG, "Hello World"); 	// output: Hello World
	AppLog.i(TAG, 3.14159265359):	// output: 3.14159265359
	AppLog.i(TAG, 1.5); 			// output: 1.5
	AppLog.i(TAG, true); 			// output: true
	AppLog.i(TAG, 1);  				// output: 1
	
You can also disable logging:

	AppLog.setMute(true);
	AppLog.i(TAG, 1);				// output: .... *crickets.

### TagLog:

And creating a TagLog instance is just as easy:

	import se.marteinn.utils.AppLog;
	
	// Create and store tagLog instance.
	TagLog log = AppLog.newTagLog(TAG);
	
	// Then call it from anywhere in your class.
	log.d("My value");				// My value
	log.d(1.5);						// 1.5

## Contributing

Want to contribute? Awesome. Just send a pull request.


## Roadmap:
* 1.1 - Support for String.format based logging.


## License

Android-AppLog is released under the [MIT License](http://www.opensource.org/licenses/MIT).