function asciibin(convert, type) {
  
  //if this is binary...
  if (type == 'binary') {
    //strip any white space
    convert = convert.replace(/ /g,'');
    
    //remove any line breaks
    convert = convert.replace(/\n/g,'');
    
    var ascii_string = '';
    var current_byte;
    
    //if the binary does not consist of 8 digit chunks (bytes)
    if (convert.length % 8 != 0) {return 'Can\'t read'}
    
    //otherwise
    else {
      //split it into bytes
      for (var i=0; i < convert.length/8; i++) {
      
        //get the current byte
        current_byte = convert.substring(i*8, (i*8)+8);
      
        //get the charcode from the current_byte and add it to the ascii_string
        if (parseInt(current_byte, 2) > 127) {
          ascii_string = 'Can\'t read'
        } else {
          ascii_string += String.fromCharCode(parseInt(current_byte, 2));
        }
      }
      return ascii_string;
    }
  }
  
  //if this is an ASCII
  if (type == 'ascii') {
    var binary_string = '';
    var binary_data = [];
    var current_letter;
    
    //separate the letters
    for (var i=0; i < convert.length; i++) {
      //get the current letter, pull the char code, and convert to binary
      current_letter = convert.substring(i, i + 1).charCodeAt(0).toString(2);
      
      //if the 'byte' is less than eight values prepend some zeros
      if (current_letter.length < 8) {
        while(current_letter.length < 8) {
          current_letter = '0' + current_letter;
        } 
      }


      binary_data.push(current_letter);

    }
    return binary_data;
  }
}