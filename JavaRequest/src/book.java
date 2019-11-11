import java.util.Date;

class book{
		
		String	bookTitle;
		String	bookDetailUrl;
		String	bookImageUrl;
		boolean isBookImageExists;
		String	bookAuthor;
		Date	bookDueDate;
		String bookDeuDateString;
		String	bookBarCode;
		String	bookCellNo;
		String	bookReniewStatus;
		boolean isBookReniewAvl;
		String bookReniewLink;
		String bookFines;
		
		
		public book() {} //empty constructor
		public book(String bookTitle, String bookDetailUrl, String bookImageUrl, boolean isBookImageExists,
				String bookAuthor, String bookDueDate, String bookBarCode, String bookCellNo, String bookReniewStatus,
				boolean isBookReniewAvl, String bookReniewLink, String bookFines) {
			super();
			this.bookTitle = bookTitle;
			this.bookDetailUrl = bookDetailUrl;
			this.bookImageUrl = bookImageUrl;
			this.isBookImageExists = isBookImageExists;
			this.bookAuthor = bookAuthor;
			this.bookDeuDateString = bookDueDate;
			this.bookBarCode = bookBarCode;
			this.bookCellNo = bookCellNo;
			this.bookReniewStatus = bookReniewStatus;
			this.isBookReniewAvl = isBookReniewAvl;
			this.bookReniewLink = bookReniewLink;
			this.bookFines = bookFines;
		}
		/**
		 * @return the bookTitle
		 */
		public String getBookTitle() {
			return bookTitle;
		}
		/**
		 * @param bookTitle the bookTitle to set
		 */
		public void setBookTitle(String bookTitle) {
			this.bookTitle = bookTitle;
		}
		/**
		 * @return the bookDetailUrl
		 */
		public String getBookDetailUrl() {
			return bookDetailUrl;
		}
		/**
		 * @param bookDetailUrl the bookDetailUrl to set
		 */
		public void setBookDetailUrl(String bookDetailUrl) {
			this.bookDetailUrl = bookDetailUrl;
		}
		/**
		 * @return the bookImageUrl
		 */
		public String getBookImageUrl() {
			return bookImageUrl;
		}
		/**
		 * @param bookImageUrl the bookImageUrl to set
		 */
		public void setBookImageUrl(String bookImageUrl) {
			this.bookImageUrl = bookImageUrl;
		}
		/**
		 * @return the isBookImageExists
		 */
		public boolean isBookImageExists() {
			return isBookImageExists;
		}
		/**
		 * @param isBookImageExists the isBookImageExists to set
		 */
		public void setBookImageExists(boolean isBookImageExists) {
			this.isBookImageExists = isBookImageExists;
		}
		/**
		 * @return the bookAuthor
		 */
		public String getBookAuthor() {
			return bookAuthor;
		}
		/**
		 * @param bookAuthor the bookAuthor to set
		 */
		public void setBookAuthor(String bookAuthor) {
			this.bookAuthor = bookAuthor;
		}
		/**
		 * @return the bookDueDate
		 */
		public Date getBookDueDate() {
			return bookDueDate;
		}
		/**
		 * @param bookDueDate the bookDueDate to set
		 */
		public void setBookDueDate(Date bookDueDate) {
			this.bookDueDate = bookDueDate;
		}
		/**
		 * @return the bookBarCode
		 */
		public String getBookBarCode() {
			return bookBarCode;
		}
		/**
		 * @param bookBarCode the bookBarCode to set
		 */
		public void setBookBarCode(String bookBarCode) {
			this.bookBarCode = bookBarCode;
		}
		/**
		 * @return the bookCellNo
		 */
		public String getBookCellNo() {
			return bookCellNo;
		}
		/**
		 * @param bookCellNo the bookCellNo to set
		 */
		public void setBookCellNo(String bookCellNo) {
			this.bookCellNo = bookCellNo;
		}
		/**
		 * @return the bookReniewStatus
		 */
		public String getBookReniewStatus() {
			return bookReniewStatus;
		}
		/**
		 * @param bookReniewStatus the bookReniewStatus to set
		 */
		public void setBookReniewStatus(String bookReniewStatus) {
			this.bookReniewStatus = bookReniewStatus;
		}
		/**
		 * @return the isBookReniewAvl
		 */
		public boolean isBookReniewAvl() {
			return isBookReniewAvl;
		}
		/**
		 * @param isBookReniewAvl the isBookReniewAvl to set
		 */
		public void setBookReniewAvl(boolean isBookReniewAvl) {
			this.isBookReniewAvl = isBookReniewAvl;
		}
		/**
		 * @return the bookReniewLink
		 */
		public String getBookReniewLink() {
			return bookReniewLink;
		}
		/**
		 * @param bookReniewLink the bookReniewLink to set
		 */
		public void setBookReniewLink(String bookReniewLink) {
			this.bookReniewLink = bookReniewLink;
		}
		/**
		 * @return the bookFines
		 */
		public String getBookFines() {
			return bookFines;
		}
		/**
		 * @param bookFines the bookFines to set
		 */
		public void setBookFines(String bookFines) {
			this.bookFines = bookFines;
		}
		@Override
		public String toString() {
			return "book [bookTitle=" + bookTitle + ", bookDetailUrl=" + bookDetailUrl + ", bookImageUrl="
					+ bookImageUrl + ", isBookImageExists=" + isBookImageExists + ", bookAuthor=" + bookAuthor
					+ ", bookDueDate=" + bookDueDate + ", bookDeuDateString=" + bookDeuDateString + ", bookBarCode="
					+ bookBarCode + ", bookCellNo=" + bookCellNo + ", bookReniewStatus=" + bookReniewStatus
					+ ", isBookReniewAvl=" + isBookReniewAvl + ", bookReniewLink=" + bookReniewLink + ", bookFines="
					+ bookFines + "]";
		}
		
	
		
		
	}
	
	