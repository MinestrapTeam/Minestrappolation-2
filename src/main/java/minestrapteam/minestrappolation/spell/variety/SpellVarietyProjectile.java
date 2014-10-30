package minestrapteam.minestrappolation.spell.variety;

import minestrapteam.minestrappolation.entity.EntitySpellProjectile;
import minestrapteam.minestrappolation.spell.Spell;
import minestrapteam.minestrappolation.spell.data.SpellCategory;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class SpellVarietyProjectile extends SpellVariety
{
	public SpellVarietyProjectile(int id, String name)
	{
		super(id, SpellCategory.OFFENSE, name);
	}
	
	@Override
	public void cast(Spell spell, EntityPlayer player, World world)
	{
		if (!world.isRemote)
		{
			SpellProjectile projectile = new SpellProjectile(world, player);
			projectile.setSpell(spell);
			world.spawnEntityInWorld(projectile);
		}
	}
	
	public static class SpellProjectile extends EntitySpellProjectile
	{
		public SpellProjectile(World world)
		{
			super(world);
		}
		
		public SpellProjectile(World world, EntityLivingBase living)
		{
			super(world, living);
		}
		
		@Override
		protected void onImpact(MovingObjectPosition mop)
		{
			if (mop.entityHit != null)
			{
				mop.entityHit.attackEntityFrom(DamageSource.magic, 0.005F * this.spell.getTotalPotency());
			}
			this.setDead();
		}
	}
}
