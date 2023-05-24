package idw.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
public class ZipDirectory {

	public static void main(String[] args) throws IOException {
		File directoryToZip = new File("C:\\projects\\workspace\\testing\\stuff");

		List<File> fileList = new ArrayList<File>();
		getAllFiles(directoryToZip, fileList);
		writeZipFile(directoryToZip, fileList, false);
	}

	public static void getAllFiles(File dir, List<File> fileList) {
		File[] files = dir.listFiles();
		if(files == null)
			return;
		for (File file : files) {
			fileList.add(file);
			if (file.isDirectory()) {
				getAllFiles(file, fileList);
			}
		}
	}

	public static void writeZipFile(File directoryToZip, List<File> fileList, boolean isTrataTemp) {
		FileOutputStream fos = null;
		ZipOutputStream zos = null;

		try {
			if(isTrataTemp == true)
				fos = new FileOutputStream(directoryToZip.getPath() + ".tmp");
			else
				fos = new FileOutputStream(directoryToZip.getPath() + ".zip");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		try {
			zos = new ZipOutputStream(fos);
			
			for (File file : fileList) {
				if (!file.isDirectory()) { // we only zip files, not directories
					try{
						addToZip(directoryToZip, file, zos);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (zos != null)
					zos.close();
				if (fos != null)
					fos.close();
				if(isTrataTemp == true)
					ArquivosDiretorios.renameFilePath(directoryToZip.getPath()+".tmp", directoryToZip.getPath()+".zip", true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void addToZip(File directoryToZip, File file, ZipOutputStream zos) throws FileNotFoundException,
			IOException {

		FileInputStream fis = new FileInputStream(file);

		// we want the zipEntry's path to be a relative path that is relative
		// to the directory being zipped, so chop off the rest of the path
		String zipFilePath = file.getCanonicalPath().substring(directoryToZip.getCanonicalPath().length() + 1,
				file.getCanonicalPath().length());
		ZipEntry zipEntry = new ZipEntry(zipFilePath);
		zos.putNextEntry(zipEntry);

		byte[] bytes = new byte[1024];
		int length;
		while ((length = fis.read(bytes)) >= 0) {
			zos.write(bytes, 0, length);
		}

		zos.closeEntry();
		fis.close();
	}

}