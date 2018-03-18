package com.fakhruddin.lfs;

import java.io.IOException;
import java.net.URI;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.AccessMode;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.DirectoryStream.Filter;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.spi.FileSystemProvider;
import java.util.Map;
import java.util.Set;

public class RedisFileSystemProvider extends FileSystemProvider {

	/**
	 *
	 */
	
	private static final String LFS_SCHEME = "lfs";

    private RedisFileSystem fileSystem;

	@Override
	public String getScheme() {
		return LFS_SCHEME;
	}

	@Override
	public FileSystem newFileSystem(URI uri, Map<String, ?> env) throws IOException {
        String scheme = uri.getScheme();
        if ((scheme == null) || !scheme.equalsIgnoreCase(getScheme())) {
            throw new IllegalArgumentException("URI scheme is not '" + getScheme() + "'");
        }
        if (fileSystem == null){
            synchronized(this){
                if (fileSystem == null){
                    fileSystem = new RedisFileSystem(this);
                }
            }    
        }
        return fileSystem;
	}

	@Override
	public FileSystem getFileSystem(URI uri) {
        if (fileSystem == null)
            throw new FileSystemNotFoundException();

        return fileSystem;
	}

	@Override
	public Path getPath(URI uri) {
		return null;
	}

	@Override
	public SeekableByteChannel newByteChannel(Path path, Set<? extends OpenOption> options, FileAttribute<?>... attrs)
			throws IOException {
		return null;
	}

	@Override
	public DirectoryStream<Path> newDirectoryStream(Path dir, Filter<? super Path> filter) throws IOException {
		return null;
	}

	@Override
	public void createDirectory(Path dir, FileAttribute<?>... attrs) throws IOException {
		
	}

	@Override
	public void delete(Path path) throws IOException {
		
	}

	@Override
	public void copy(Path source, Path target, CopyOption... options) throws IOException {
		
	}

	@Override
	public void move(Path source, Path target, CopyOption... options) throws IOException {
		
	}

	@Override
	public boolean isSameFile(Path path, Path path2) throws IOException {
		return false;
	}

	@Override
	public boolean isHidden(Path path) throws IOException {
		return false;
	}

	@Override
	public FileStore getFileStore(Path path) throws IOException {
		return null;
	}

	@Override
	public void checkAccess(Path path, AccessMode... modes) throws IOException {
		
	}

	@Override
	public <V extends FileAttributeView> V getFileAttributeView(Path path, Class<V> type, LinkOption... options) {
		return null;
	}

	@Override
	public <A extends BasicFileAttributes> A readAttributes(Path path, Class<A> type, LinkOption... options)
			throws IOException {
		return null;
	}

	@Override
	public Map<String, Object> readAttributes(Path path, String attributes, LinkOption... options) throws IOException {
		return null;
	}

	@Override
	public void setAttribute(Path path, String attribute, Object value, LinkOption... options) throws IOException {
		
	}

}