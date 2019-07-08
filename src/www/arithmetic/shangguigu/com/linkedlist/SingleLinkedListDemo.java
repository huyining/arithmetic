package www.arithmetic.shangguigu.com.linkedlist;

/**
 * 单链表
 *
 * @author: huyining
 * @since :    2019-07-01
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {

        // 进行测试
        // 先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        // 创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        // 加入
        // singleLinkedList.add(hero1);
        // singleLinkedList.add(hero4);
        // singleLinkedList.add(hero2);
        // singleLinkedList.add(hero3);
        // 加入按照编号的顺序 singleLinkedList.addByOrder(hero1); singleLinkedList.addByOrder(hero4); singleLinkedList.addByOrder(hero2); singleLinkedList.addByOrder(hero3);
        // 显示一把 singleLinkedList.list();
        // 测试修改节点的代码
        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
        singleLinkedList.update(newHeroNode);
        System.out.println("修改后的链表情况~~");
        singleLinkedList.list();
        // 删除一个节点 singleLinkedList.del(1); singleLinkedList.del(4);
        System.out.println("删除后的链表情况~~");
        singleLinkedList.list();

    }


    static class SingleLinkedList {

        private HeroNode head = new HeroNode(0, "", "");

        /**
         * 添加节点到单向链表
         *
         * @param node
         */
        public void add(HeroNode node) {

            HeroNode temp = head;

            while (true) {
                if (temp.next == null) {
                    break;
                }
                temp = temp.next;
            }

            temp.next = node;
        }

        /**
         * 添加到指定的位置
         *
         * @param node
         */
        public void addByOrder(HeroNode node) {

            HeroNode temp = node;
            Boolean flag = false;

            while (true) {
                if (temp == null) {
                    break;
                }
                if (temp.next.no > node.no) {
                    break;
                } else if (temp.next.no == node.no) {
                    flag = true;
                    break;
                }
                temp = temp.next;
            }

            if (flag) {
                System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", node.no);
            } else {
                node.next = temp.next;
                temp.next = node;
            }
        }


        /**
         * 根据no进行跟新
         *
         * @param node
         */
        public void update(HeroNode node) {

            if (head.next == null) {
                System.out.println("链表为空....");
                return;
            }

            HeroNode temp = head.next;
            Boolean flag = false;

            while (true) {
                if (temp == null) {
                    break;
                }

                if (temp.no == node.no) {
                    flag = true;
                    break;
                }

                temp = temp.next;
            }

            if (flag) {

                temp.name = node.name;
                temp.nickname = node.nickname;
            } else {
                System.out.printf("没有找到 编号 %d 的节点，不能修改\n", node.no);
            }
        }

        /**
         * 根据no进行跟新
         *
         * @param no
         */
        public void del(int no) {

            HeroNode temp = head;
            Boolean flag = false;

            while (true) {
                // 链表的最后
                if (temp.next == null) {
                    break;
                }

                // 找到了要删除节点的上一个节点
                if (temp.next.no == no) {
                    flag = true;
                    break;
                }

                temp = temp.next;
            }

            if (flag) {

                temp.next = temp.next.next;
            } else {
                System.out.printf("要删除的 %d 节点不存在\n", no);
            }
        }


        /**
         * 遍历链表信息
         */
        public void list() {

            if (head.next == null) {
                System.out.println("链表为空");
                return;
            }

            HeroNode temp = head.next;
            while (true) {
                if (temp == null) {
                    break;
                }
                System.out.println(temp);

                temp = temp.next;
            }
        }


    }


    static class HeroNode {

        private int no;

        private String name;

        private String nickname;

        private HeroNode next;

        public HeroNode(int no, String name, String nickname) {
            this.no = no;
            this.name = name;
            this.nickname = nickname;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickname='" + nickname +
                    '}';
        }
    }
}
