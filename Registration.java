public class Registration {
    private static int memberCount = 1;

    public static Member registerMember(String name, int age, String address, String type) {
        String memberId = generateMemberId();
        return new Member(name, age, address, type, memberId);
    }

    private static String generateMemberId() {
        String memberId = "MLM" + String.format("%03d", memberCount);
        memberCount++;
        return memberId;
    }
}
