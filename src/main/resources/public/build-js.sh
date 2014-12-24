#!/bin/sh

echo Begin
yui-compressor -o vendors.min.js \
    backbone.marionette/jquery.js \
    backbone.marionette/underscore.js \
    backbone.marionette/backbone.js \
    backbone.marionette/backbone.marionette.js 
echo Done! Check vendors.min.js
