import org.jsoup.nodes.Element;

class jsoupBook {
	Element image;
	Element title;
	Element author;
	Element due_date;
	Element bar_code;
	Element cell_no;
	Element renew;
	Element fines;
	

	public jsoupBook() {
	}

	public jsoupBook(Element image, Element title, Element author, Element due_date, Element bar_code, Element cell_no,
			Element renew, Element fines) {
		super();
		this.image = image;
		this.title = title;
		this.author = author;
		this.due_date = due_date;
		this.bar_code = bar_code;
		this.cell_no = cell_no;
		this.renew = renew;
		this.fines = fines;
	}

	/**
	 * @return the image
	 */
	public Element getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(Element image) {
		this.image = image;
	}

	/**
	 * @return the title
	 */
	public Element getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(Element title) {
		this.title = title;
	}

	/**
	 * @return the author
	 */
	public Element getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(Element author) {
		this.author = author;
	}

	/**
	 * @return the due_date
	 */
	public Element getDue_date() {
		return due_date;
	}

	/**
	 * @param due_date the due_date to set
	 */
	public void setDue_date(Element due_date) {
		this.due_date = due_date;
	}

	/**
	 * @return the bar_code
	 */
	public Element getBar_code() {
		return bar_code;
	}

	/**
	 * @param bar_code the bar_code to set
	 */
	public void setBar_code(Element bar_code) {
		this.bar_code = bar_code;
	}

	/**
	 * @return the cell_no
	 */
	public Element getCell_no() {
		return cell_no;
	}

	/**
	 * @param cell_no the cell_no to set
	 */
	public void setCell_no(Element cell_no) {
		this.cell_no = cell_no;
	}

	/**
	 * @return the renew
	 */
	public Element getRenew() {
		return renew;
	}

	/**
	 * @param renew the renew to set
	 */
	public void setRenew(Element renew) {
		this.renew = renew;
	}

	/**
	 * @return the fines
	 */
	public Element getFines() {
		return fines;
	}

	/**
	 * @param fines the fines to set
	 */
	public void setFines(Element fines) {
		this.fines = fines;
	}

	@Override
	public String toString() {
		return "jsoupBook [image=" + image + ", title=" + title + ", author=" + author + ", due_date=" + due_date
				+ ", bar_code=" + bar_code + ", cell_no=" + cell_no + ", renew=" + renew + ", fines=" + fines + "]";
	}
	
	

}
