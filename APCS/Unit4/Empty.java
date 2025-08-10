public class Empty {
  public void addMembers(String[] names, int gradYear) {
    for (int i = 0; i < names.length; i++) {
      memberList.add(new MemberInfo(names[i], gradYear, true));

    }
  } // 3

  public ArrayList<MemberInfo> removeMembers(int year) {
    ArrayList<MemberInfo> graduated = new ArrayList<MemberInfo>();
    for (int i = 0; i < memberList.size(); i++) {
      MemberInfo student = memberList.get(i);
      if (student.getGradYear() <= year && student.isGoodStanding() == true) {
        graduated.add(memberList.remove(i));
        i--;
      }
    }
    return graduated;
  } // 

}
