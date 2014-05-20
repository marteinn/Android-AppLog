Android-AppLog
==============
AppLog is a simple Android logger that gives you a detailed output and more log options.

## How it works
AppLog works as a wrapper around android.util.Log and allows detailed logging by traversing through the Stack and printing class/method/linenumber, nicer output with String.format support, more loggable types by using Object.toString and the possibility to mute logging with setMute.

## Implementation

### AppLog:

Just import and call AppLog, it will resolve method and class invoking the trace and accept primary types by invoking Object.toString

	import se.marteinn.utils.AppLog;

	AppLog.i("Hello World"); 	// output: Hello World (method:99)
	AppLog.i(3.14159265359):	// output: 3.14159265359 (method:99)
	AppLog.i(1.5); 				// output: 1.5 	(method:99)
	AppLog.i(true); 			// output: true	(method:99)
	AppLog.i(1);  				// output: 1	(method:99)

You can also supply a tag variable, as you would with regular logging.

	AppLog.i(TAG, "Hello World"); 	// output: Hello World

It is also possible to log with String.format syntax using LogFormat.

	import se.marteinn.utils.AppLog;
	import se.marteinn.utils.LogFormat;

	AppLog.i(new LogFormat("name=%s"), "martin");					// output: name=martin
	AppLog.i(new LogFormat("name=%s, month=%d"), "martin", 1);		// output: name=martin, month=1
	AppLog.i(new LogFormat("date=%tD"), new Date());				// output: date=05/18/14


You can also disable logging:

	AppLog.setMute(true);
	AppLog.i(TAG, 1);				// output: .... *crickets.

And remove namespace from class when using class resolve.

	AppLog.i(1);				// se.marteinn.YourClass	1 (method:99)

	AppLog.setSkipNamespace(true);
	AppLog.i(1);				// YourClass				1 (method:99)


## Contributing

Want to contribute? Awesome. Just send a pull request.


## License

Android-AppLog is released under the [MIT License](http://www.opensource.org/licenses/MIT).
