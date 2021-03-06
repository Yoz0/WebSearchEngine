package article_list_parser;

import java.io.File;
import java.io.IOException;
import java.util.Map;


/* 
 * This program reads the .sql.gz files containing Wikipedia's page metadata and page links
 * (or reads the cache files), writes out cached versions of the parsed data (for faster processing
 * next time), iteratively computes the PageRank of every page, and writes out the raw PageRank vector.
 * 
 * Run the program on the command line with no arguments. You may need to modify the file names below.
 * The program prints a bunch of statistics and progress messages on standard output.
 */

public final class ParseWiki {
	
	/*---- Input/output files configuration ----*/
	
	private static final File PAGE_ID_TITLE_SQL_FILE = new File("frwiki-latest-page.sql.gz");           // Original input file
	private static final File PAGE_ID_TITLE_RAW_FILE = new File("wikipedia-page-id-title.raw");  // Cache after preprocessing
	
	
	/*---- Main program ----*/
	
	public static void getListArticles() throws IOException {
		// Create and write page-ID-title data
		Map<String,Integer> titleToId;
		titleToId = PageIdTitleMap.readSqlFile(PAGE_ID_TITLE_SQL_FILE);
		PageIdTitleMap.writeRawFile(titleToId, PAGE_ID_TITLE_RAW_FILE);
	}
		
}
