package cn.jsu.Service;

import javax.swing.JFrame;

import javax.swing.JOptionPane;
import cn.jsu.Dao.Impl.DatabaseOperateImpl;
import cn.jsu.Vo.User;


/**
 * �޸��û�����
 * @author Black
 *
 */

public class ModifyPassword {
	/**
	 * ����һ���޸�����ķ���
	 * @param op	������
	 * @param np	������
	 * @param rnp	ȷ��������
	 * @param u		�û���
	 */
	public void Modify(String op, String np, String rnp, User u, JFrame frame) throws Exception {
		if(op.equals(u.getPassword())) {
			if(np == null || "".equals(np.trim())) {
					JOptionPane.showMessageDialog(null, "���벻��Ϊ�գ�");
					return;
				}
			if(np.equals(rnp)) {
				String sql = "update user set password = '"+np+"'"+" where username = '"+u.getUsername()+"'";
				new DatabaseOperateImpl().Update(sql);
				JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
				frame.dispose();
			}else {
				JOptionPane.showMessageDialog(null, "���벻һ�£�");
			}
		}else {
			JOptionPane.showMessageDialog(null, "��ǰ���벻һ�£�");
		}
	}

}
