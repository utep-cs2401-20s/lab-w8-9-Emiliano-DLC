class AminoAcidLL {
  char aminoAcid;
  String[] codons;
  int[] counts;
  AminoAcidLL next;

  AminoAcidLL() {

  }


  /********************************************************************************************/
  /* Creates a new node, with a given amino acid/codon
   * pair and increments the codon counter for that codon.
   * NOTE: Does not check for repeats!! */
  AminoAcidLL(String inCodon) {
    this.aminoAcid = AminoAcidResources.getAminoAcidFromCodon(inCodon);
    this.codons = AminoAcidResources.getCodonListForAminoAcid(aminoAcid);
    this.counts = new int[codons.length - 1];
    for (int i = 0; i < codons.length; i++) {
      counts[i] = 0;
    }
    this.next = null;
  }

  /********************************************************************************************/
  /* Recursive method that increments the count for a specific codon:
   * If it should be at this node, increments it and stops,
   * if not passes the task to the next node.
   * If there is no next node, add a new node to the list that would contain the codon.
   */
  private void addCodon(String inCodon) {
    //AminoAcidLL node = new AminoAcidLL(inCodon);
    if (this.aminoAcid == AminoAcidResources.getAminoAcidFromCodon(inCodon))
      addCodon(inCodon);
    else if (this.next != null)
      next.addCodon(inCodon);
    //next

    //base case:
    // (if next == null)
    //if this node has this codon
    //increment codoon

  }


  /********************************************************************************************/
  /* Shortcut to find the total number of instances of this amino acid */
  private int totalCount() {
    return 0;
  }

  /********************************************************************************************/
  /* helper method for finding the list difference on two matching nodes
   *  must be matching, but this is not tracked */
  private int totalDiff(AminoAcidLL inList) {
    return Math.abs(totalCount() - inList.totalCount());
  }


  /********************************************************************************************/
  /* helper method for finding the list difference on two matching nodes
   *  must be matching, but this is not tracked */
  private int codonDiff(AminoAcidLL inList) {
    int diff = 0;
    for (int i = 0; i < codons.length; i++) {
      diff += Math.abs(counts[i] - inList.counts[i]);
    }
    return diff;
  }

  /********************************************************************************************/
  /* Recursive method that finds the differences in **Amino Acid** counts.
   * the list *must* be sorted to use this method */
  public int aminoAcidCompare(AminoAcidLL inList) {
    //empty list
    //a=totalCount();
    return 0;
  }

  /********************************************************************************************/
  /* Same ad above, but counts the codon usage differences
   * Must be sorted. */
  public int codonCompare(AminoAcidLL inList) {

    return 0;
  }


  /********************************************************************************************/
  /* Recursively returns the total list of amino acids in the order that they are in in the linked list. */
  public char[] aminoAcidList() {
    //base case
    //if next == null
    return new char[]{};
  }

  /********************************************************************************************/
  /* Recursively returns the total counts of amino acids in the order that they are in in the linked list. */
  public int[] aminoAcidCounts() {
    return new int[]{};
  }


  /********************************************************************************************/
  /* recursively determines if a linked list is sorted or not */
  public boolean isSorted() {
    while ()
      return false;
  }


  /********************************************************************************************/
  /* Static method for generating a linked list from an RNA sequence */
  public static AminoAcidLL createFromRNASequence(String inSequence) {
    AminoAcidLL list = new AminoAcidLL();
    while (list != null) {
      list.aminoAcid = AminoAcidResources.getAminoAcidFromCodon(inSequence);
      list = list.next;
    }
    return list;
  }


  /********************************************************************************************/
  /* sorts a list by amino acid character*/
  public static AminoAcidLL sort(AminoAcidLL inList) {
    AminoAcidLL temp;
    AminoAcidLL currentNode = inList;
    while (currentNode.next != null) {
      if (currentNode.aminoAcid > currentNode.next.aminoAcid) {
        temp = currentNode.next;
        currentNode.next = currentNode;
        currentNode = temp;
      }
      return sort(inList);
    }
    return inList;
  }
}

     // while (currentNode.next != null) {
       //       if (currentNode.aminoAcid > currentNode.next.aminoAcid) {
         //     temp = currentNode;
            //  currentNode = currentNode.next;
             // currentNode.next = temp;
             // }
             // return sort(inList.next);
             // }