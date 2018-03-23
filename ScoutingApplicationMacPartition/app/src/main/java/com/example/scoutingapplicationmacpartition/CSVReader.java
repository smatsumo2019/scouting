package com.example.scoutingapplicationmacpartition;

//Definitions
String baseDir = android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
String fileName = "savedData.csv";
String filePath = baseDir + File.separator + fileName;
File f = new File(filePath );
CSVWriter writer;

// Checking if everything listed above exists
if(f.exists() && !f.isDirectory()){
mFileWriter = new FileWriter(filePath , true);
writer = new CSVWriter(mFileWriter);
}
else {
writer = new CSVWriter(new FileWriter(filePath));
}
String[] data = {"matchString= " + values[0] + ", teamString= " + values[1] + ", autoScaleString= " + values[2] + ", autoSwitchString= " + values[3] + ", teleopScaleString= " + values[4] + ", teleopSwitchString= " + values[5] + ", teleopExchangeString= " + values[6] + ", competitionString= " + values[7]};

writer.writeNext(data);

writer.close();
