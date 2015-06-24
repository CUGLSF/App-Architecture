package com.android.app.core.filesystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.android.app.framework.controller.AbstractChildSystem;
import com.android.app.framework.controller.IController;
import com.android.app.framework.filesystem.FileSystem;

import android.content.Context;
import android.os.Environment;

/**
 * Android �ļ�����ϵͳ
 * Created by frodo on 2015/6/20.
 */
public class AndroidFileSystem extends AbstractChildSystem implements FileSystem {

    private String sdcardPath; // SD��·��
    private String filePath; //�ļ�·��
    private Context context;

    public AndroidFileSystem(IController controller) {
        super(controller);
        this.context = (Context) controller.getContext();
        sdcardPath = Environment.getExternalStorageDirectory().getPath() + "//";
        filePath = this.context.getFilesDir().getPath() + "//";
    }

    /**
     * ��SD���ϴ����ļ�
     *
     * @throws IOException
     */
    public File creatSDFile(String fileName) throws IOException {
        File file = new File(sdcardPath + fileName);
        file.createNewFile();
        return file;
    }

    /**
     * ɾ��SD���ϵ��ļ�
     *
     * @param fileName
     */
    public boolean delSDFile(String fileName) {
        File file = new File(sdcardPath + fileName);
        if (!file.exists() || file.isDirectory()) {
            return false;
        }
        file.delete();
        return true;
    }

    /**
     * ��SD���ϴ���Ŀ¼
     *
     * @param dirName
     */
    public File creatSDDir(String dirName) {
        File dir = new File(sdcardPath + dirName);
        dir.mkdir();
        return dir;
    }

    /**
     * ɾ��SD���ϵ�Ŀ¼
     *
     * @param dirName
     */
    public boolean delSDDir(String dirName) {
        File dir = new File(sdcardPath + dirName);
        return delDir(dir);
    }

    /**
     * �޸�SD���ϵ��ļ���Ŀ¼��
     *
     * @param oldfileName
     * @param newFileName
     *
     * @return
     */
    public boolean renameSDFile(String oldfileName, String newFileName) {
        File oleFile = new File(sdcardPath + oldfileName);
        File newFile = new File(sdcardPath + newFileName);
        return oleFile.renameTo(newFile);
    }

    /**
     * ����SD���ϵĵ����ļ�
     *
     * @param srcFileName
     * @param destFileName
     *
     * @return
     *
     * @throws IOException
     */
    public boolean copySDFileTo(String srcFileName, String destFileName)
            throws IOException {
        File srcFile = new File(sdcardPath + srcFileName);
        File destFile = new File(sdcardPath + destFileName);
        return copyFileTo(srcFile, destFile);
    }

    /**
     * ����SD����ָ��Ŀ¼�������ļ�
     *
     * @param srcDirName
     * @param destDirName
     *
     * @return
     *
     * @throws IOException
     */
    public boolean copySDFilesTo(String srcDirName, String destDirName)
            throws IOException {
        File srcDir = new File(sdcardPath + srcDirName);
        File destDir = new File(sdcardPath + destDirName);
        return copyFilesTo(srcDir, destDir);
    }

    /**
     * �ƶ�SD���ϵĵ����ļ�
     *
     * @param srcFileName
     * @param destFileName
     *
     * @return
     *
     * @throws IOException
     */
    public boolean moveSDFileTo(String srcFileName, String destFileName)
            throws IOException {
        File srcFile = new File(sdcardPath + srcFileName);
        File destFile = new File(sdcardPath + destFileName);
        return moveFileTo(srcFile, destFile);
    }

    /**
     * �ƶ�SD���ϵ�ָ��Ŀ¼�������ļ�
     *
     * @param srcDirName
     * @param destDirName
     *
     * @return
     *
     * @throws IOException
     */
    public boolean moveSDFilesTo(String srcDirName, String destDirName)
            throws IOException {
        File srcDir = new File(sdcardPath + srcDirName);
        File destDir = new File(sdcardPath + destDirName);
        return moveFilesTo(srcDir, destDir);
    }

    /**
     * ���ļ�д��sd������:writeSDFile("test.txt");
     *
     * @param fileName
     *
     * @return
     *
     * @throws IOException
     */
    public Output writeSDFile(String fileName) throws IOException {
        File file = new File(sdcardPath + fileName);
        FileOutputStream fos = new FileOutputStream(file);
        return new Output(fos);
    }

    /**
     * ��ԭ���ļ��ϼ���д�ļ�����:appendSDFile("test.txt");
     *
     * @param fileName
     *
     * @return
     *
     * @throws IOException
     */
    public Output appendSDFile(String fileName) throws IOException {
        File file = new File(sdcardPath + fileName);
        FileOutputStream fos = new FileOutputStream(file, true);
        return new Output(fos);
    }

    /**
     * ��SD����ȡ�ļ�����:readSDFile("test.txt");
     *
     * @param fileName
     *
     * @return
     *
     * @throws IOException
     */
    public Input readSDFile(String fileName) throws IOException {
        File file = new File(sdcardPath + fileName);
        FileInputStream fis = new FileInputStream(file);
        return new Input(fis);
    }

    /**
     * ����˽���ļ�
     *
     * @param fileName
     *
     * @return
     *
     * @throws IOException
     */
    public File creatDataFile(String fileName) throws IOException {
        File file = new File(filePath + fileName);
        file.createNewFile();
        return file;
    }

    /**
     * ����˽��Ŀ¼
     *
     * @param dirName
     *
     * @return
     */
    public File creatDataDir(String dirName) {
        File dir = new File(filePath + dirName);
        dir.mkdir();
        return dir;
    }

    /**
     * ɾ��˽���ļ�
     *
     * @param fileName
     *
     * @return
     */
    public boolean delDataFile(String fileName) {
        File file = new File(filePath + fileName);
        return delFile(file);
    }

    /**
     * ɾ��˽��Ŀ¼
     *
     * @param dirName
     *
     * @return
     */
    public boolean delDataDir(String dirName) {
        File file = new File(filePath + dirName);
        return delDir(file);
    }

    /**
     * ����˽���ļ���
     *
     * @param oldName
     * @param newName
     *
     * @return
     */
    public boolean renameDataFile(String oldName, String newName) {
        File oldFile = new File(filePath + oldName);
        File newFile = new File(filePath + newName);
        return oldFile.renameTo(newFile);
    }

    /**
     * ��˽��Ŀ¼�½����ļ�����
     *
     * @param srcFileName  �� ����·�����ļ���
     * @param destFileName
     *
     * @return
     *
     * @throws IOException
     */
    public boolean copyDataFileTo(String srcFileName, String destFileName)
            throws IOException {
        File srcFile = new File(filePath + srcFileName);
        File destFile = new File(filePath + destFileName);
        return copyFileTo(srcFile, destFile);
    }

    /**
     * ����˽��Ŀ¼��ָ��Ŀ¼�������ļ�
     *
     * @param srcDirName
     * @param destDirName
     *
     * @return
     *
     * @throws IOException
     */
    public boolean copyDataFilesTo(String srcDirName, String destDirName)
            throws IOException {
        File srcDir = new File(filePath + srcDirName);
        File destDir = new File(filePath + destDirName);
        return copyFilesTo(srcDir, destDir);
    }

    /**
     * �ƶ�˽��Ŀ¼�µĵ����ļ�
     *
     * @param srcFileName
     * @param destFileName
     *
     * @return
     *
     * @throws IOException
     */
    public boolean moveDataFileTo(String srcFileName, String destFileName)
            throws IOException {
        File srcFile = new File(filePath + srcFileName);
        File destFile = new File(filePath + destFileName);
        return moveFileTo(srcFile, destFile);
    }

    /**
     * �ƶ�˽��Ŀ¼�µ�ָ��Ŀ¼�µ������ļ�
     *
     * @param srcDirName
     * @param destDirName
     *
     * @return
     *
     * @throws IOException
     */
    public boolean moveDataFilesTo(String srcDirName, String destDirName)
            throws IOException {
        File srcDir = new File(filePath + srcDirName);
        File destDir = new File(filePath + destDirName);
        return moveFilesTo(srcDir, destDir);
    }

    /**
     * ���ļ�д��Ӧ��˽�е�filesĿ¼����:writeFile("test.txt");
     *
     * @param fileName
     *
     * @return
     *
     * @throws IOException
     */
    public Output wirteFile(String fileName) throws IOException {
        OutputStream os = context.openFileOutput(fileName,
                Context.MODE_WORLD_WRITEABLE);
        return new Output(os);
    }

    /**
     * ��ԭ���ļ��ϼ���д�ļ�����:appendFile("test.txt");
     *
     * @param fileName
     *
     * @return
     *
     * @throws IOException
     */
    public Output appendFile(String fileName) throws IOException {
        OutputStream os = context.openFileOutput(fileName, Context.MODE_APPEND);
        return new Output(os);
    }

    /**
     * ��Ӧ�õ�˽��Ŀ¼files��ȡ�ļ�����:readFile("test.txt");
     *
     * @param fileName
     *
     * @return
     *
     * @throws IOException
     */
    public Input readFile(String fileName) throws IOException {
        InputStream is = context.openFileInput(fileName);
        return new Input(is);
    }

    /**
     * ɾ��һ���ļ�
     *
     * @param file
     *
     * @return
     */
    public boolean delFile(File file) {
        if (file.isDirectory()) {
            return false;
        }
        return file.delete();
    }

    /**
     * ɾ��һ��Ŀ¼�������Ƿǿ�Ŀ¼��
     *
     * @param dir
     */
    public boolean delDir(File dir) {
        if (dir == null || !dir.exists() || dir.isFile()) {
            return false;
        }
        for (File file : dir.listFiles()) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                delDir(file);// �ݹ�
            }
        }
        dir.delete();
        return true;
    }

    /**
     * ����һ���ļ�,srcFileԴ�ļ���destFileĿ���ļ�
     *
     * @param srcFile
     * @param destFile
     *
     * @return
     *
     * @throws IOException
     */
    public boolean copyFileTo(File srcFile, File destFile) throws IOException {
        if (srcFile.isDirectory() || destFile.isDirectory()) {
            return false;// �ж��Ƿ����ļ�
        }
        FileInputStream fis = new FileInputStream(srcFile);
        FileOutputStream fos = new FileOutputStream(destFile);
        int readLen = 0;
        byte[] buf = new byte[1024];
        while ((readLen = fis.read(buf)) != -1) {
            fos.write(buf, 0, readLen);
        }
        fos.flush();
        fos.close();
        fis.close();
        return true;
    }

    /**
     * ����Ŀ¼�µ������ļ���ָ��Ŀ¼
     *
     * @param srcDir
     * @param destDir
     *
     * @return
     *
     * @throws IOException
     */
    public boolean copyFilesTo(File srcDir, File destDir) throws IOException {
        if (!srcDir.isDirectory() || !destDir.isDirectory()) {
            return false;// �ж��Ƿ���Ŀ¼
        }
        if (!destDir.exists()) {
            return false;// �ж�Ŀ��Ŀ¼�Ƿ����
        }
        File[] srcFiles = srcDir.listFiles();
        for (int i = 0; i < srcFiles.length; i++) {
            if (srcFiles[i].isFile()) {
                // ���Ŀ���ļ�
                File destFile = new File(destDir.getPath() + "//"
                        + srcFiles[i].getName());
                copyFileTo(srcFiles[i], destFile);
            } else if (srcFiles[i].isDirectory()) {
                File theDestDir = new File(destDir.getPath() + "//"
                        + srcFiles[i].getName());
                copyFilesTo(srcFiles[i], theDestDir);
            }
        }
        return true;
    }

    /**
     * �ƶ�һ���ļ�
     *
     * @param srcFile
     * @param destFile
     *
     * @return
     *
     * @throws IOException
     */
    public boolean moveFileTo(File srcFile, File destFile) throws IOException {
        boolean iscopy = copyFileTo(srcFile, destFile);
        if (!iscopy) {
            return false;
        }
        delFile(srcFile);
        return true;
    }

    /**
     * �ƶ�Ŀ¼�µ������ļ���ָ��Ŀ¼
     *
     * @param srcDir
     * @param destDir
     *
     * @return
     *
     * @throws IOException
     */
    public boolean moveFilesTo(File srcDir, File destDir) throws IOException {
        if (!srcDir.isDirectory() || !destDir.isDirectory()) {
            return false;
        }
        File[] srcDirFiles = srcDir.listFiles();
        for (int i = 0; i < srcDirFiles.length; i++) {
            if (srcDirFiles[i].isFile()) {
                File oneDestFile = new File(destDir.getPath() + "//"
                        + srcDirFiles[i].getName());
                moveFileTo(srcDirFiles[i], oneDestFile);
                delFile(srcDirFiles[i]);
            } else if (srcDirFiles[i].isDirectory()) {
                File oneDestFile = new File(destDir.getPath() + "//"
                        + srcDirFiles[i].getName());
                moveFilesTo(srcDirFiles[i], oneDestFile);
                delDir(srcDirFiles[i]);
            }

        }
        return true;
    }
}
